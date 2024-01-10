import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { TokenStorageService } from '../../services/token-storage.service';
import { Router } from '@angular/router';
import { ProfessorService } from '../../services/professor.service';
import { NavbarComponent } from '../shared/navbar/navbar.component';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-professors',  
  standalone: true,
  imports: [NavbarComponent, ReactiveFormsModule, CommonModule],
  templateUrl: './professors.component.html',
  styleUrl: './professors.component.css',
})
export class ProfessorsComponent implements OnInit{
  professorForm = new FormGroup({
    firstName: new FormControl('SARL'),
    lastName: new FormControl('Test'),
    email: new FormControl('test@gmail.com'),
    gender: new FormControl('male'),
    address: new FormControl('1 rue du test'),
    city: new FormControl('Test'),
    postalCode: new FormControl(12345),
    schoolPhoneNumber: new FormControl('0654321098'),
    phoneNumber: new FormControl('0765432109'),
    hiringDate: new FormControl('2020-01-01'),
    leavingDate: new FormControl('2023-01-01'),
  });

  displayedColumns: string[] = [
    'Professeur ID',
    'Prenom',
    'Nom',
    'Email',
    'Sexe',
    'Adresse',
    'Ville',
    'Code Postal',
    'Téléphone ecole',
    'Téléphone du Contact',
    'Date Emboche',
    'Date Depart',
    'Actions',
  ];
  professorsList: any[] = [];
  editMode = false;
  currentprofessorId: number = 0;
  // professor: any;

  constructor(
    private professorService: ProfessorService,
    private tokenStorageService: TokenStorageService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.getProfessors();
  }

  getProfessors() {
    return this.professorService.getProfessors().subscribe({
      next: (data: any) => {
        this.professorsList = data;
      },
      error: (e) => {
        if (e.status === 403) {
          this.tokenStorageService.logout();
        }
      },
    });
  }

  handleSearch(event: any) {
    const keyWord = event.target.value.toLowerCase();
    if (keyWord) {
      this.professorsList = this.professorsList.filter((professor: any) => {
        const fullName = `${professor.firstName.toLowerCase()} ${professor.lastName.toLowerCase()}`;
        return fullName.includes(keyWord);
      });
    } else {
      this.getProfessors();
    }
  }

  // getProfessorByFirstAndLastName(firstName: string, lastName:string) {
  //   return this.professorService.getProfessorByFirstAndLastName(firstName,lastName).subscribe({
  //     next: (data) =>{
  //       this.professor = data;
  //     },
  //     error: (e) => {
  //       if (e.status === 403) {
  //         this.tokenStorageService.logout();
  //       }
  //     },
  //   });
  // }

  getProfessorById(professorId: number) {
    return this.professorService.getProfessorById(professorId).subscribe({
      next: (data) => console.log(data),
      error: (e) => {
        if (e.status === 403) {
          this.tokenStorageService.logout();
        }
      },
    });
  }

  handleProfessorForm() {
    if (this.editMode) {
      this.updateProfessor();
    } else {
      this.addProfessor();
    }
  }

  handleUpdateProfessor(professor: any) {
    this.editMode = true;
    this.currentprofessorId = professor.professorId;
    this.professorForm.patchValue(professor);
  }

  addProfessor() {
    if (this.professorForm.valid) {
      this.professorService
        .addProfessor(this.professorForm.value)
        .subscribe({
          next: (data) =>{
            this.getProfessors();
          },
          error: (e) => {
            if (e.status === 403) {
              this.tokenStorageService.logout();
            }
          },
        });
    } else {
      console.log('invalid form');
    }
  }

  updateProfessor() {
    this.professorService
      .updateProfessor(this.currentprofessorId, this.professorForm.value)
      .subscribe({
        next: (data) => {
          this.getProfessors();
          this.editMode = false;
        },
        error: (e) => {
          if (e.status === 403) {
            this.tokenStorageService.logout();
          }
        },
      });
  }

  deleteProfessor(professorId: number) {
    this.professorService.deleteProfessor(professorId).subscribe({
      next: (data) => {
        this.professorsList = this.professorsList.filter(
          (entreprise: any) => {
            return entreprise.professorId !== professorId;
          }
        );
      },
      error: (e) => {
        if (e.status === 403) {
          this.tokenStorageService.logout();
        }
      },
    });
  }
}

import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule } from '@angular/forms';

import { CommonModule } from '@angular/common';
import { NavbarComponent } from '../components/shared/navbar/navbar.component';
import { EtudiantsService } from '../services/etudiants.service';
import { TokenStorageService } from '../services/token-storage.service';

@Component({
  selector: 'app-etudiants',
  standalone: true,
  imports: [NavbarComponent, ReactiveFormsModule, CommonModule],
  templateUrl: './etudiants.component.html',
  styleUrls: ['./etudiants.component.css'],
})
export class EtudiantsComponent implements OnInit {
  etudiantForm = new FormGroup({
    studentId: new FormControl(1234),
    firstName: new FormControl('Emy'),
    lastName: new FormControl('Di'),
    email: new FormControl('test@gmail.com'),
    gender: new FormControl('M'),
    dateOfBirth: new FormControl('2002-02-01'),
    address: new FormControl('1 rue du test'),
    city: new FormControl('Test'),
    postalCode: new FormControl(12345),
    phoneNumber: new FormControl('0696957047'),
    promo: new FormControl('2022'),
    promoNumber: new FormControl('220'),
    mention: new FormControl('Bien'),
  });

  displayedColumns: string[] = [
    'studentId',
    'Prenom',
    'nom',
    'Email',
    'Genre',
    'Date de naissance',
    'Adresse',
    'Ville',
    'Code Postal',
    'Téléphone',
    'Promo',
    'Numéro promo',
    'Mention',
    'Actions',
  ];
  etudiantsList: any[] = [];
  currentstudentId = 0;
  editMode = false;
  etudiant: any;
  etudiantsService: any;

  constructor(
    private etudiantService: EtudiantsService,
    private tokenStorageService: TokenStorageService
  ) {}

  ngOnInit(): void {
    this.getEtudiants();
  }

  getEtudiants() {
    return this.etudiantsService.getEtudiants().subscribe({
      next: (data: any) => {
        this.etudiantsList = data;
      },
      error: (e: { status: number }) => {
        if (e.status === 403) {
          this.tokenStorageService.logout();
        }
      },
    });
  }

  handleSearch(event: any) {
    const keyWord = event.target.value.toLowerCase();
    if (keyWord) {
      this.etudiantsList = this.etudiantsList.filter((etudiant: any) => {
        const fullName = `${etudiant.firstName.toLowerCase()} ${etudiant.lastName.toLowerCase()}`;
        return fullName.includes(keyWord);
      });
    } else {
      this.getEtudiants();
    }
  }

  getEtudiantName(lastName: string) {
    return this.etudiantsService.getEtudiantName(lastName).subscribe({
      next: (data: any) => console.log(data),
      error: (e: { status: number }) => {
        if (e.status === 403) {
          this.tokenStorageService.logout();
        }
      },
    });
  }

  handleEtudiantForm() {
    if (this.editMode) {
      this.updateEtudiant();
    } else {
      this.addEtudiant();
    }
  }

  handleUpdateEtudiant(etudiant: any) {
    this.editMode = true;
    this.currentstudentId = etudiant.studentId;
    this.etudiantForm.patchValue(etudiant);
  }

  addEtudiant() {
    if (this.etudiantForm.valid) {
      this.etudiantsService.addEtudiants(this.etudiantForm.value).subscribe({
        next: (data: any) => {
          this.getEtudiants();
        },
        error: (e: { status: number; }) => {
          if (e.status === 403) {
            this.tokenStorageService.logout();
          }
        },
      });
    } else {
      console.log('invalid form');
    }
  }

  updateEtudiant() {
    this.etudiantsService
      .updateEtudiants(this.currentstudentId, this.etudiantForm.value)
      .subscribe({
        next: (data: any) => {
          this.getEtudiants();
          this.editMode = false;
        },
        error: (e: { status: number; }) => {
          if (e.status === 403) {
            this.tokenStorageService.logout();
          }
        },
      });
  }

  deleteEtudiant(studentId: number) {
    this.etudiantsService.deleteEtudiant(studentId).subscribe({
      next: (data: any) => {
        this.etudiantsList = this.etudiantsList.filter((etudiant: any) => {
          return etudiant.studentId !== studentId;
        });
      },
      error: (e: { status: number; }) => {
        if (e.status === 403) {
          this.tokenStorageService.logout();
        }
      },
    });
  }
}

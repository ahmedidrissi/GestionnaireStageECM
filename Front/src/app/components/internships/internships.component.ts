import { Component, OnInit } from '@angular/core';
import { NavbarComponent } from '../shared/navbar/navbar.component';
import { CommonModule } from '@angular/common';
import { FormControl, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { EntreprisesComponent } from '../entreprises/entreprises.component';
import { TutorsComponent } from '../tutors/tutors.component';
import { TokenStorageService } from '../../services/token-storage.service';
import { Router } from '@angular/router';
import { InternshipsService } from '../../services/internships.service';

@Component({
  selector: 'app-internships',
  standalone: true,
  imports: [
    NavbarComponent,
    EntreprisesComponent,
    TutorsComponent,
    CommonModule,
    ReactiveFormsModule,
  ],
  templateUrl: './internships.component.html',
  styleUrl: './internships.component.css',
})
export class InternshipsComponent implements OnInit {
  internshipForm = new FormGroup({
    promo: new FormControl(2020),
    promoNumber: new FormControl(20),
    professor: new FormControl(''),
    tutor: new FormControl(''),
    enterprise: new FormControl(''),
    type: new FormControl(''),
    year: new FormControl(2020),
    appreciation: new FormControl(''),
  });

  displayedColumns: string[] = [
    'Numéro du Stage',
    'Promotion',
    "Numéro d'Étudiant",
    'Professeur',
    'Tuteur',
    'Entreprise',
    'Type',
    'Année',
    'Appréciation',
    'Actions',
  ];

  internshipsList: any[] = [];
  editMode = false;
  currentInternshipNumber: number = 0;

  constructor(
    private internshipsService: InternshipsService,
    private tokenStorageService: TokenStorageService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.getInternships();
  }

  getInternships() {
    // return this.internshipsService.getInternships().subscribe({
    //   next: (data: any) => {
    //     this.internshipsList = data;
    //   },
    //   error: (err) => {
    //     if (err.status === 403) {
    //       this.tokenStorageService.logout();
    //     }
    //   },
    // });
  }

  handleSearch(event: any) {
    const keyWord = event.target.value.toLowerCase();
    if (keyWord) {
      this.internshipsList = this.internshipsList.filter((internship) => {
        return (
          internship.firstName.toLowerCase().includes(keyWord) ||
          internship.lastName.toLowerCase().includes(keyWord)
        );
      });
    } else {
      this.getInternships();
    }
  }

  handleInternshipForm() {
    if (this.editMode) {
      this.updateInternship();
    } else {
      this.addInternship();
    }
  }

  handleUpdateInternship(internship: any) {
    this.editMode = true;
    this.currentInternshipNumber = internship.internshipNumber;
    this.internshipForm.patchValue(internship);
  }

  addInternship() {
    // this.internshipsService
    //   .addInternship(this.internshipForm.value)
    //   .subscribe((data) => {
    //     this.getInternships();
    //     this.internshipForm.reset();
    //   });
  }

  updateInternship() {
    // this.internshipsService
    //   .updateInternship(this.internshipForm.value, this.currentInternshipNumber)
    //   .subscribe((data) => {
    //     this.getInternships();
    //     this.internshipForm.reset();
    //     this.editMode = false;
    //   });
  }

  deleteInternship(internshipNumber: number) {
    // this.internshipsService
    //   .deleteInternship(internshipNumber)
    //   .subscribe((data) => {
    //     this.getInternships();
    //   });
  }

}

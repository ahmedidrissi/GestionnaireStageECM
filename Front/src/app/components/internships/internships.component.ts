import { Component, OnInit } from '@angular/core';
import { NavbarComponent } from '../shared/navbar/navbar.component';
import { CommonModule } from '@angular/common';
import { FormControl, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { TokenStorageService } from '../../services/token-storage.service';
import { Router } from '@angular/router';
import { InternshipsService } from '../../services/internships.service';
import { SkillsComponent } from '../skills/skills.component';
import { InternshipsDatesComponent } from '../internships-dates/internships-dates.component';

@Component({
  selector: 'app-internships',
  standalone: true,
  imports: [
    NavbarComponent,
    InternshipsDatesComponent,
    SkillsComponent,
    CommonModule,
    ReactiveFormsModule,
  ],
  templateUrl: './internships.component.html',
  styleUrl: './internships.component.css',
})
export class InternshipsComponent implements OnInit {
  internshipForm = new FormGroup({
    promo: new FormControl(2020),
    promoNumber: new FormControl('13'),
    professor: new FormControl(4321),
    tutor: new FormControl(1234),
    company: new FormControl(123456789),
    internshipType: new FormControl(11),
    year: new FormControl(2020),
    appreciation: new FormControl('Bien'),
  });

  displayedColumns: string[] = [
    'ID',
    'Promotion',
    "Numéro d'Étudiant",
    'Professeur',
    'Tuteur',
    'Entreprise',
    'Type de Stage',
    'Année',
    'Appréciation',
    'Actions',
  ];

  internshipsList: any[] = [];
  editMode = false;
  currentInternshipId: number = 0;

  constructor(
    private internshipsService: InternshipsService,
    private tokenStorageService: TokenStorageService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.getInternships();
  }

  getInternships() {
    this.internshipsService.getInternships().subscribe({
      next: (data: any) => {
        this.internshipsList = data;
      },
      error: (err) => {
        if (err.status === 403) {
          this.tokenStorageService.logout();
        }
      },
    });
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
    this.currentInternshipId = internship.internshipId;
    this.internshipForm.patchValue(internship);
  }

  addInternship() {
    this.internshipsService.addInternship(this.internshipForm.value).subscribe({
      next: (data) => {
        this.getInternships();
        this.internshipForm.reset();
      },
      error: (err) => {
        if (err.status === 403) {
          this.tokenStorageService.logout();
        }
      },
    });
  }

  updateInternship() {
    this.internshipsService
      .updateInternship(this.currentInternshipId, this.internshipForm.value)
      .subscribe({
        next: (data) => {
          this.getInternships();
          this.internshipForm.reset();
          this.editMode = false;
        },
        error: (err) => {
          if (err.status === 403) {
            this.tokenStorageService.logout();
          }
        },
      });
  }

  deleteInternship(internshipId: number) {
    this.internshipsService.deleteInternship(internshipId).subscribe({
      next: (data) => {
        this.getInternships();
      },
      error: (err) => {
        if (err.status === 403) {
          this.tokenStorageService.logout();
        }
      },
    });
  }
}

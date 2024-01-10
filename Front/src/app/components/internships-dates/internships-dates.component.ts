import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { InternshipsDatesService } from '../../services/internships-dates.service';
import { TokenStorageService } from '../../services/token-storage.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-internships-dates',
  standalone: true,
  imports: [ReactiveFormsModule, CommonModule],
  templateUrl: './internships-dates.component.html',
  styleUrl: './internships-dates.component.css',
})
export class InternshipsDatesComponent implements OnInit {
  internshipsDatesForm = new FormGroup({
    internshipType: new FormControl(''),
    year: new FormControl(),
    startDate: new FormControl(''),
    endDate: new FormControl(''),
  });

  displayedColumns: string[] = [
    'ID',
    'Type de Stage',
    'Année',
    'Date de Début',
    'Date de Fin',
    'Actions',
  ];

  internshipsDatesList: any[] = [];
  editMode = false;
  currentInternshipDateId: number = 0;

  constructor(
    private internshipsDatesService: InternshipsDatesService,
    private tokenStorageService: TokenStorageService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.getInternshipsDates();
  }

  getInternshipsDates() {
    this.internshipsDatesService.getInternshipsDates().subscribe({
      next: (internshipsDatesList: any) => {
        this.internshipsDatesList = internshipsDatesList;
      },
      error: (err) => {
        console.log(err);
      },
    });
  }

  handleSearch(event: any) {
    const keyWord = event.target.value;
    if (keyWord) {
      this.internshipsDatesList = this.internshipsDatesList.filter(
        (internshipDate) => internshipDate.year.toString().includes(keyWord)
      );
    } else {
      this.getInternshipsDates();
    }
  }

  handleInternshipDateForm() {
    if (this.editMode) {
      this.updateInternshipDate();
    } else {
      this.addInternshipDate();
    }
  }

  handleUpdateInternshipDate(internshipDate: any) {
    this.editMode = true;
    this.currentInternshipDateId = internshipDate.id;
    this.internshipsDatesForm.patchValue(internshipDate);
  }

  addInternshipDate() {
    this.internshipsDatesService
      .addInternshipDate(this.internshipsDatesForm.value)
      .subscribe({
        next: (data) => {
          this.getInternshipsDates();
          this.internshipsDatesForm.reset();
        },
        error: (err) => {
          console.log(err);
        },
      });
  }

  updateInternshipDate() {
    this.internshipsDatesService
      .updateInternshipDate(
        this.currentInternshipDateId,
        this.internshipsDatesForm.value
      )
      .subscribe({
        next: (data) => {
          this.getInternshipsDates();
          this.internshipsDatesForm.reset();
          this.editMode = false;
        },
        error: (err) => {
          console.log(err);
        },
      });
  }

  deleteInternshipDate(internshipDateId: number) {
    this.internshipsDatesService
      .deleteInternshipDate(internshipDateId)
      .subscribe({
        next: (data) => {
          this.getInternshipsDates();
        },
        error: (err) => {
          if (err.status === 403) {
            this.tokenStorageService.logout();
          }
        },
      });
  }
}

import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { EntreprisesService } from '../../services/entreprises.service';
import { TokenStorageService } from '../../services/token-storage.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-entreprises',
  standalone: true,
  imports: [ReactiveFormsModule, CommonModule],
  templateUrl: './entreprises.component.html',
  styleUrl: './entreprises.component.css',
})
export class EntreprisesComponent implements OnInit {
  entrepriseForm = new FormGroup({
    siretNumber: new FormControl(),
    legalForm: new FormControl(''),
    businessName: new FormControl(''),
    address: new FormControl(''),
    city: new FormControl(''),
    postalCode: new FormControl(),
    tutorPhoneNumber: new FormControl(''),
    fax: new FormControl(''),
    contact: new FormControl(''),
    contactPhoneNumber: new FormControl(''),
    email: new FormControl(''),
  });

  displayedColumns: string[] = [
    'Numéro SIRET',
    'Forme Juridique',
    'Raison Sociale',
    'Adresse',
    'Ville',
    'Code Postal',
    'Téléphone du Tuteur',
    'Fax',
    'Contact',
    'Téléphone du Contact',
    'Email',
    'Actions',
  ];
  entreprisesList: any[] = [];
  editMode = false;
  currentSiretNumber: number = 0;

  constructor(
    private entreprisesService: EntreprisesService,
    private tokenStorageService: TokenStorageService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.getEntreprises();
  }

  getEntreprises() {
    return this.entreprisesService.getEntreprises().subscribe({
      next: (data: any) => {
        this.entreprisesList = data;
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
      this.entreprisesList = this.entreprisesList.filter((entreprise: any) => {
        return entreprise.businessName.toLowerCase().includes(keyWord);
      });
    } else {
      this.getEntreprises();
    }
  }

  getEntrepriseBySiretNumber(siretNumber: number) {
    return this.entreprisesService
      .getEntrepriseBySiretNumber(siretNumber)
      .subscribe({
        next: (data) => console.log(data),
        error: (e) => {
          if (e.status === 403) {
            this.tokenStorageService.logout();
          }
        },
      });
  }

  getEntrepriseByBusinessName(businessName: string) {
    return this.entreprisesService
      .getEntrepriseByBusinessName(businessName)
      .subscribe({
        next: (data) => console.log(data),
        error: (e) => {
          if (e.status === 403) {
            this.tokenStorageService.logout();
          }
        },
      });
  }

  handleEntrepriseForm() {
    if (this.editMode) {
      this.updateEntreprise();
    } else {
      this.addEntreprise();
    }
  }

  handleUpdateEntreprise(entreprise: any) {
    this.editMode = true;
    this.currentSiretNumber = entreprise.siretNumber;
    this.entrepriseForm.patchValue(entreprise);
  }

  addEntreprise() {
    if (this.entrepriseForm.valid) {
      this.entreprisesService
        .addEntreprise(this.entrepriseForm.value)
        .subscribe({
          next: (data) => {
            this.getEntreprises();
            this.entrepriseForm.reset();
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

  updateEntreprise() {
    this.entreprisesService
      .updateEntreprise(this.currentSiretNumber, this.entrepriseForm.value)
      .subscribe({
        next: (data) => {
          this.getEntreprises();
          this.editMode = false;
          this.entrepriseForm.reset();
        },
        error: (e) => {
          if (e.status === 403) {
            this.tokenStorageService.logout();
          }
        },
      });
  }

  deleteEntreprise(siretNumber: number) {
    this.entreprisesService.deleteEntreprise(siretNumber).subscribe({
      next: (data) => {
        this.getEntreprises();
      },
      error: (e) => {
        if (e.status === 403) {
          this.tokenStorageService.logout();
        }
      },
    });
  }
}

import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { NavbarComponent } from '../shared/navbar/navbar.component';
import { CommonModule } from '@angular/common';
import { EntreprisesService } from '../../services/entreprises.service';

@Component({
  selector: 'app-entreprises',
  standalone: true,
  imports: [NavbarComponent, ReactiveFormsModule, CommonModule],
  templateUrl: './entreprises.component.html',
  styleUrl: './entreprises.component.css',
})
export class EntreprisesComponent implements OnInit {
  entrepriseForm = new FormGroup({
    siretNumber: new FormControl(123456789),
    legalForm: new FormControl('SARL'),
    businessName: new FormControl('Test'),
    address: new FormControl('1 rue du test'),
    city: new FormControl('Test'),
    postalCode: new FormControl(12345),
    tutorPhoneNumber: new FormControl('0654321098'),
    fax: new FormControl('0543210987'),
    contact: new FormControl('Omar'),
    contactPhoneNumber: new FormControl('0765432109'),
    email: new FormControl('test@gmail.com'),
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
    'Actions'
  ];
  entreprisesList: any[] = [];
  
  constructor(private entreprisesService: EntreprisesService) {}

  ngOnInit(): void {
    this.getEntreprises();
  }

  getEntreprises() {
    return this.entreprisesService.getEntreprises()
      .subscribe((data: any) => {
        this.entreprisesList = data;
      });
  }

  addEntreprise() {
    if (this.entrepriseForm.valid) {
      this.entreprisesService.addEntreprise(this.entrepriseForm.value)
        .subscribe((data: any) => {
          this.entreprisesList.push(data);
        });
    } else {
      console.log('invalid form');
    }
  }

  updateEntreprise(siretNumber: string) {
    console.log('update');
  }

  deleteEntreprise(siretNumber: string) {
    console.log('delete');
  }

}

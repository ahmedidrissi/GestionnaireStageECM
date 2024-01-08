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
    siretNumber: new FormControl(''),
    legalForm: new FormControl(''),
    businessName: new FormControl(''),
    address: new FormControl(''),
    city: new FormControl(''),
    postalCode: new FormControl(''),
    tutorPhoneNumber: new FormControl(''),
    fax: new FormControl(''),
    contact: new FormControl(''),
    email: new FormControl(''),
  });

  displayedColumns: string[] = [
    'Numéro SIRET',
    'Forme Juridique',
    'Raison Sociale',
    'Adresse',
    'Ville',
    'Code Postal',
    'Téléphone Tuteur',
    'Fax',
    'Contact',
    'Email',
    'Actions'
  ];
  entreprisesList: any[] = [
    {
      siretNumber: '123456789',
      legalForm: 'SAS 1',
      businessName: 'Test 1',
      address: '1 rue du test 1',
      city: 'Test 1',
      postalCode: '12345',
      tutorPhoneNumber: '0123456789',
      fax: '0123456789',
      contact: 'Test 1',
      email: 'test1@gmail.com'
    },
    {
      siretNumber: '987654321',
      legalForm: 'SAS 2',
      businessName: 'Test 2',
      address: '2 rue du test 2',
      city: 'Test 2',
      postalCode: '54321',
      tutorPhoneNumber: '9876543210',
      fax: '9876543210',
      contact: 'Test 2',
      email: 'test2@gmail.com'
    },
  ];
  
  constructor(private entreprisesService: EntreprisesService) {}

  ngOnInit(): void {
    this.getEntreprises();
  }

  getEntreprises() {
    return this.entreprisesService.getEntreprises()
      .subscribe((data: any) => {
        console.log(data);
        return data;
      });
  }

  addEntreprise() {
    if (this.entrepriseForm.valid) {
      // this.entreprisesService.addEntreprise(this.entrepriseForm.value)
      console.log(this.entrepriseForm.value);
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

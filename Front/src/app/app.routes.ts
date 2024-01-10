import { Routes } from '@angular/router';
import { AuthenticationComponent } from './components/authentication/authentication.component';
import { HomeComponent } from './components/home/home.component';
import { EntreprisesComponent } from './components/entreprises/entreprises.component';
import { EtudiantsComponent } from './etudiants/etudiants.component';

export const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'authenticate', component: AuthenticationComponent },
  { path: 'entreprises', component: EntreprisesComponent },
  { path: 'students', component: EtudiantsComponent },
];

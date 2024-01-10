import { Routes } from '@angular/router';
import { AuthenticationComponent } from './components/authentication/authentication.component';
import { HomeComponent } from './components/home/home.component';
import { EntreprisesComponent } from './components/entreprises/entreprises.component';
import { EtudiantsComponent } from './etudiants/etudiants.component';
import { ProfessorsComponent } from './components/professors/professors.component';
import { TutorsComponent } from './components/tutors/tutors.component';


export const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'authenticate', component: AuthenticationComponent },
  { path: 'entreprises', component: EntreprisesComponent },
  { path: 'students', component: EtudiantsComponent },
  { path: 'professors', component: ProfessorsComponent},
  { path: 'tutors', component: TutorsComponent },
];

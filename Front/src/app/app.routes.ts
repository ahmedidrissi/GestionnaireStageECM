import { Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { AuthenticationComponent } from './components/authentication/authentication.component';
import { DashboardComponent } from './components/dashboard/dashboard.component';

import { ProfessorsComponent } from './components/professors/professors.component';
import { InternshipsComponent } from './components/internships/internships.component';
import { StudentsComponent } from './components/students/students.component';



export const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'authenticate', component: AuthenticationComponent },
  { path: 'dashboard', component: DashboardComponent },
  { path: 'students', component: StudentsComponent },
  { path: 'professors', component: ProfessorsComponent},
  { path: 'internships', component: InternshipsComponent},
];

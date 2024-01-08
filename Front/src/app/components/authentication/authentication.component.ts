import { Component, OnInit } from '@angular/core';
import { NavbarComponent } from '../shared/navbar/navbar.component';
import { AuthenticationService } from '../../services/authentication.service';
import { Router } from '@angular/router';
import { ReactiveFormsModule, FormControl, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-authentication',
  standalone: true,
  imports: [NavbarComponent, ReactiveFormsModule],
  templateUrl: './authentication.component.html',
  styleUrl: './authentication.component.css'
})
export class AuthenticationComponent implements OnInit {

  authenticationForm = new FormGroup({
    email: new FormControl(''),
    password: new FormControl('')
  });

  constructor(
    private authenticationService: AuthenticationService,
    private router: Router
  ) { 
  }

  ngOnInit(): void {
  }

  handleLogin(): void {
    if (this.authenticationForm.value.email && this.authenticationForm.value.password) {
      this.authenticationService.authenticate(this.authenticationForm.value.email, this.authenticationForm.value.password);
    } else {
      console.log('Please enter a valid email and password.');
    }
  }

}

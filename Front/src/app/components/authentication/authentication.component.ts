import { Component } from '@angular/core';
import { NavbarComponent } from '../shared/navbar/navbar.component';

@Component({
  selector: 'app-authentication',
  standalone: true,
  imports: [NavbarComponent],
  templateUrl: './authentication.component.html',
  styleUrl: './authentication.component.css'
})
export class AuthenticationComponent {

}

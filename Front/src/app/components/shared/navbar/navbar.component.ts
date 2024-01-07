import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-navbar',
  standalone: true,
  imports: [],
  templateUrl: './navbar.component.html',
  styleUrl: './navbar.component.css'
})
export class NavbarComponent {

  constructor(
    private router: Router, 
    private route: ActivatedRoute
  ) {}

  navigate(route: string): void {
    this.router.navigate([route], { relativeTo: this.route });
  }
  
}

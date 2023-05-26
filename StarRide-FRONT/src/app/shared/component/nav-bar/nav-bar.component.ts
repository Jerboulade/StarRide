import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.scss']
})
export class NavBarComponent {

  constructor(private _auth : AuthService, private _router : Router) {}

  get isConnected() : boolean {
    return localStorage.getItem('session_info') != null;
  }
  logout() {
    this._auth.logout();
    this._router.navigateByUrl('login');
  }

}

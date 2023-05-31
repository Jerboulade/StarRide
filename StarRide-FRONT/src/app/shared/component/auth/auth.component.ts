import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from '../../services/auth.service';
import { environment } from 'src/environments/environment';


@Component({
  selector: 'app-auth',
  templateUrl: './auth.component.html',
  styleUrls: ['./auth.component.scss']

})
export class AuthComponent {

  loginForm : FormGroup;
  registerForm : FormGroup;
  registered : boolean | undefined = undefined;

  constructor(private _auth : AuthService, private _router : Router) {
    this.loginForm = new FormGroup({
      email : new FormControl('', [Validators.required]),
      password : new FormControl('', Validators.required)
    })
    this.registerForm = new FormGroup({
      email : new FormControl('', [Validators.required]),
      password : new FormControl('', Validators.required),
      confirm : new FormControl('', Validators.required)
    })
  }

  submitLogin() {
    this._auth.login(this.loginForm.value['email'], this.loginForm.value['password']).subscribe({
      next : () => {
        this._router.navigateByUrl('/');
      }
    });
    //console.log(this.loginForm.value['email'] +" "+ this.loginForm.value['password'])
  }

  submitRegister() {
    console.log(this.registerForm.value['email'], this.registerForm.value['password'], this.registerForm.value['confirm']);

    this._auth.register(this.registerForm.value['email'], this.registerForm.value['password'], this.registerForm.value['confirm']).subscribe({
      next : () => {
        this._router.navigateByUrl('/');
      }
    });
  }

}

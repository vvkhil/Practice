import { Component } from '@angular/core';
import { AuthorizationService } from '../services/authorization.service';
import { FormsModule } from '@angular/forms';
import { UserService } from '../services/user.service';
import User from '../entities/user';

@Component({
  selector: 'app-profile',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './profile.component.html',
  styleUrl: './profile.component.css'
})
export class ProfileComponent {
  login = '';
  email = '';
  password = '';
  user = new User;
  
  constructor(private authorizationService: AuthorizationService,
    private userService: UserService) {
    authorizationService.user.subscribe(user => {
      this.user = user;
      this.login = user.login;
      this.email = user.email;
      this.password = user.password;
    });
  }

  logOut() {
    this.authorizationService.logOut();
    window.location.href = '/signin';
  }

  async removeUser() {
    await this.userService.removeUserById(this.user.id);
    this.logOut();
  }
}
import { Component } from '@angular/core';
import { FormsModule } from "@angular/forms";
import { Router } from "@angular/router";
import Shop from "../entities/shop";
import { ShopService } from '../services/shop.service';
import { UserService } from '../services/user.service';
import { NgFor } from '@angular/common';
import User from '../entities/user';
import { AuthorizationService } from '../services/authorization.service';

@Component({
  selector: 'app-shop.add',
  standalone: true,
  imports: [FormsModule, NgFor],
  templateUrl: './shop.add.component.html',
  styleUrl: './shop.add.component.css'
})

export class ShopAddComponent {
  shop: Shop = new Shop();
  user = new User;

  constructor(private shopService: ShopService, private router: Router, 
    private authorizationService: AuthorizationService, private userService: UserService) {
      authorizationService.user.subscribe(user => {
        this.user = user;
      });
    }

  async addShop() {
    this.shop.user = this.user;
    await this.shopService.addShop(this.shop);
    this.router.navigate(["/shops"]);
  }
}
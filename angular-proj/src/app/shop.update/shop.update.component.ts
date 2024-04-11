import { Component } from '@angular/core';
import { FormsModule } from "@angular/forms";
import { Router, ActivatedRoute } from "@angular/router";
import Shop from "../entities/shop"
import { ShopService } from '../services/shop.service';
import { UserService } from '../services/user.service';
import { NgFor } from '@angular/common';
import User from '../entities/user';
import { AuthorizationService } from '../services/authorization.service';

@Component({
  selector: 'app-shop.update',
  standalone: true,
  imports: [FormsModule, NgFor],
  templateUrl: './shop.update.component.html',
  styleUrl: './shop.update.component.css'
})

export class ShopUpdateComponent {
  shop: Shop = new Shop();
  id: number;
  user = new User;

  constructor(private shopService: ShopService, private router: Router, 
    private authorizationService: AuthorizationService, private userService: UserService,
    private activateRoute: ActivatedRoute) {
      this.id = activateRoute.snapshot.params["id"];
      authorizationService.user.subscribe(user => {
        this.user = user;
      });
    }

  async ngOnInit(){
    this.shop = await this.shopService.getShopById(this.id);
    console.log(this.shop)
  }

  async updateShop() {
    this.shop.user = this.user;
    await this.shopService.updateShop(this.shop);
    this.router.navigate(["/shops"]);
  }
}
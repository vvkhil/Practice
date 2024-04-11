import { Component } from '@angular/core';
import { FormsModule } from "@angular/forms";
import { Router, ActivatedRoute } from "@angular/router";
import { ShopService } from '../services/shop.service';
import { ShoeService } from '../services/shoe.service';
import { NgFor } from '@angular/common';
import Shop from '../entities/shop';
import Shoe from '../entities/shoe';

@Component({
  selector: 'app-get.shoes.by.shop',
  standalone: true,
  imports: [FormsModule, NgFor],
  templateUrl: './get.shoes.by.shop.component.html',
  styleUrl: './get.shoes.by.shop.component.css'
})
export class GetShoeByShopComponent {
  shop: Shop = new Shop();
  shoes: Shoe[] = [];
  id: number;

  constructor(private shopService: ShopService, 
              private shoeService: ShoeService,
              private router: Router, 
              private activateRoute: ActivatedRoute) {
    this.id = activateRoute.snapshot.params["id"];
  }

  async ngOnInit(){
    this.shop = await this.shopService.getShopById(this.id);
    await this.getShoeByShop();
  }

  async getShoeByShop() {
    this.shoes = await this.shoeService.getShoesByShopId(this.shop.id);
  }
}

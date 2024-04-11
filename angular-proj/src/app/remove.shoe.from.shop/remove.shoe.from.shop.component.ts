import { Component } from '@angular/core';
import { FormsModule } from "@angular/forms";
import { Router, ActivatedRoute } from "@angular/router";
import CatalogShoes from "../entities/catalog.shoes"
import { ShopService } from '../services/shop.service';
import { ShoeService } from '../services/shoe.service';
import { NgFor } from '@angular/common';
import Shop from '../entities/shop';
import Shoe from '../entities/shoe';

@Component({
  selector: 'app-remove.shoe.from.shop',
  standalone: true,
  imports: [FormsModule, NgFor],
  templateUrl: './remove.shoe.from.shop.component.html',
  styleUrl: './remove.shoe.from.shop.component.css'
})
export class RemoveShoeFromShopComponent {
  shop: Shop = new Shop();
  shoes: Shoe[] = [];
  catalogShoe: CatalogShoes = new CatalogShoes();
  id: number;

  constructor(private shopService: ShopService, 
              private shoeService: ShoeService,
              private router: Router, 
              private activateRoute: ActivatedRoute) {
    this.id = activateRoute.snapshot.params["id"];
  }

  async ngOnInit(){
    this.shop = await this.shopService.getShopById(this.id);
    this.shoes = await this.shoeService.getShoes();
    console.log(this.shop)
  }

  async removeShoeFromShop() {
    await this.shopService.removeShoeFromShop(this.shop.id, this.catalogShoe.shoeId);
    this.router.navigate(["/shops"]);
  }
}

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
  selector: 'app-add.shoe.to.shop',
  standalone: true,
  imports: [FormsModule, NgFor],
  templateUrl: './add.shoe.to.shop.component.html',
  styleUrl: './add.shoe.to.shop.component.css'
})
export class AddShoeToShopComponent {
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

  async addShoeToShop() {
    await this.shopService.addShoeToShop(this.shop.id, this.catalogShoe.shoeId);
    this.router.navigate(["/shops"]);
  }
}

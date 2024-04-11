import { Component } from '@angular/core';
import { ShopService } from '../services/shop.service';
import  Shop  from '../entities/shop';
import { RouterLink } from '@angular/router';
import { NgFor } from '@angular/common';

@Component({
  selector: 'app-shop',
  standalone: true,
  imports: [RouterLink, NgFor],
  templateUrl: './shop.component.html',
  styleUrl: './shop.component.css'
})

export class ShopComponent {  
  shops: Shop[] = [];

  constructor(private shopService: ShopService) {}

  async ngOnInit(){
    this.shops = await this.shopService.getShops();
  }

  async removeShop(id: number) {
    await this.shopService.removeShopById(id)
    this.ngOnInit();
  }
}
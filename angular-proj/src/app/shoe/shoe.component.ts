import { Component } from '@angular/core';
import { ShoeService } from '../services/shoe.service';
import  Shoe  from '../entities/shoe';
import { RouterLink } from '@angular/router';
import { NgFor } from '@angular/common';

@Component({
  selector: 'app-shoe',
  standalone: true,
  imports: [RouterLink, NgFor],
  templateUrl: './shoe.component.html',
  styleUrl: './shoe.component.css'
})

export class ShoeComponent {
  shoes: Shoe[] = [];

  constructor(private shoeService: ShoeService) {}

  async ngOnInit(){
    this.shoes = await this.shoeService.getShoes();
  }

  async removeShoe(id: number) {
    await this.shoeService.removeShoeById(id)
    this.ngOnInit();
  }
}
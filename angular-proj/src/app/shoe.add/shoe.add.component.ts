import { Component } from '@angular/core';
import { FormsModule } from "@angular/forms";
import { Router } from "@angular/router";
import Shoe from "../entities/shoe";
import { ShoeService } from '../services/shoe.service';
import { NgFor } from '@angular/common';

@Component({
  selector: 'app-shoe.add',
  standalone: true,
  imports: [FormsModule, NgFor],
  templateUrl: './shoe.add.component.html',
  styleUrl: './shoe.add.component.css'
})

export class ShoeAddComponent {
  shoe: Shoe = new Shoe();

  constructor(private shoeService: ShoeService, private router: Router) {}

  async addShoe() {
    console.log(this.shoe)
    await this.shoeService.addShoe(this.shoe);
    this.router.navigate(["/shoes"]);
  }
}
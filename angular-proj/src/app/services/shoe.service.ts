import { Injectable } from '@angular/core';
import axios from "axios"
import Shoe from "../entities/shoe"

@Injectable({
    providedIn: 'root'
})
export class ShoeService {

    constructor() { }

    async getShoes() {
        let response = await axios.get('/shoes')
        return response.data
    }

    async getShoeById(id: number) {
        let response = await axios.get('/shoes/' + id)
        return response.data
    }

    async removeShopById(id: number) {
        let response = await axios.delete('/shops/' + id)
        return response.data
    }

    async addShoe(shoe: Shoe) {
        let response = await axios.post('/shoes/add/', shoe)
        return response.data
    }

    async updateShoe(shoe: Shoe) {
        let response = await axios.post('/shoes/update/' + shoe.id, shoe)
        return response.data
    }

    async getShoesByShopId(shopId: number) {
        let response = await axios.get(`/shops/get/${shopId}/shoes`);
        return response.data;
    }

}
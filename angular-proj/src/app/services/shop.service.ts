import { Injectable } from '@angular/core';
import axios from "axios"
import Shop from "../entities/shop"

@Injectable({
    providedIn: 'root'
})
export class ShopService {

    constructor() { }

    async getShops() {
        let response = await axios.get('/shops')
        return response.data
    }

    async getShopById(id: number) {
        let response = await axios.get('/shops/' + id)
        return response.data
    }

    async removeShopById(id: number) {
        let response = await axios.delete('/shops/' + id)
        return response.data
    }

    async addShop(shop: Shop) {
        let response = await axios.post('/shops/add/', shop)
        return response.data
    }

    async updateShop(shop: Shop) {
        let response = await axios.put('/shops/update/' + shop.id, shop)
        return response.data
    }

    async getShopsByShoeId(shoeId: number) {
        let response = await axios.get(`/shops/${shoeId}/shoes`);
        return response.data;
    }

    async addShoeToShop(shopId: number, shoeId: number) {
        const response = await axios.post(`/shops/add/${shopId}/shoes/${shoeId}`)
        return response.data;
    }

    async removeShoeFromShop(shopId: number, shoeId: number) {
        const response = await axios.delete(`/shops/delete/${shopId}/shoes/${shoeId}`)
        return response.data;
    }
}
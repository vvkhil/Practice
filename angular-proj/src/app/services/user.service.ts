import { Injectable } from '@angular/core';
import axios from 'axios';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor() { }

  async getUserById(id: string) {
    const response = await axios.get(`/users/${id}`);

    return response.data;
  }

  async getUsers() {
    const response = await axios.get('/users');

    return response.data;
  }

  async updateUser(id: number, login: string, email: string, password: string) {
    const response = await axios.put('/users', {
        id,
        login,
        email,
        password
    });

    return response.data;
  }

  async removeUserById(id: number) {
    const response = await axios.delete(`/users/${id}`);

    return response.data;
  }
}
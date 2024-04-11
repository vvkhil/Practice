import { Routes } from '@angular/router';
import { ProfileComponent } from './profile/profile.component';
import { SignupComponent } from './signup/signup.component';
import { SigninComponent } from './signin/signin.component';
import { ShoeComponent } from './shoe/shoe.component';
import { ShoeAddComponent } from './shoe.add/shoe.add.component';
import { ShoeUpdateComponent } from './shoe.update/shoe.update.component';
import { ShopComponent } from './shop/shop.component';
import { ShopAddComponent } from './shop.add/shop.add.component';
import { ShopUpdateComponent } from './shop.update/shop.update.component';
import { AddShoeToShopComponent } from './add.shoe.to.shop/add.shoe.to.shop.component';
import { RemoveShoeFromShopComponent } from './remove.shoe.from.shop/remove.shoe.from.shop.component';
import { GetShoeByShopComponent } from './get.shoes.by.shop/get.shoes.by.shop.component';

export const routes: Routes = [
    // {
    //     path: 'users',
    //     component: UsersComponent
    // },
    {
        path: 'shoes',
        component: ShoeComponent
    },
    {
        path: 'shoes/add',
        component: ShoeAddComponent
    },
    {
        path: 'shoes/update/:id',
        component: ShoeUpdateComponent
    },
    {
        path: 'shops',
        component: ShopComponent
    },
    {
        path: 'shops/add',
        component: ShopAddComponent
    },
    {
        path: 'shops/update/:id',
        component: ShopUpdateComponent
    },
    {
        path: 'shops/add/:id',
        component: AddShoeToShopComponent
    },
    {
        path: 'shops/delete/:id',
        component: RemoveShoeFromShopComponent
    },
    {
        path: 'shops/get/:id',
        component: GetShoeByShopComponent
    },
    // {
    //     path: 'chats/:chatId',
    //     component: ChatComponent
    // },
    {
        path: 'profile',
        component: ProfileComponent
    },
    {
        path: 'signup',
        component: SignupComponent
    },
    {
        path: 'signin',
        component: SigninComponent
    }
    // {
    //     path: '**',
    //     redirectTo: '/users'
    // }
];
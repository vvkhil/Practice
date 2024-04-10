import React, { useState, useContext } from 'react';
import { addBaskShop } from "../api/shopService"
import { useNavigate } from "react-router-dom";
import { AppContext } from '../contexts/contexts';
import "./shops.css"

export default function BaskShopAdd() {
    const navigate = useNavigate();

    const [title, setTitle] = useState('');
    const [rating, setRating] = useState('');

    const appContext = useContext(AppContext);

    return (
        <section className="form-container">
            <input
                placeholder="Title"
                className="form-control"
                type="text"
                onChange={(e) => setTitle(e.target.value)}
            />
            <input
                placeholder="Rating"
                className="form-control"
                type="number"
                onChange={(e) => setRating(e.target.value)}
            />
            <button
                className="btn btn-info"
                onClick={addBaskShopClick}>
                Add
            </button>
        </section>
    );

    async function addBaskShopClick() {
        let shop = {}
        shop.id = null
        shop.title = title
        shop.rating = rating
        shop.user = appContext.user
        await addBaskShop(shop)
        navigate('/shops')
    }
}

import React, { useState, useContext } from 'react';
import { getBaskShopById, updateBaskShop } from "../api/shopService"
import { useLoaderData, useNavigate } from "react-router-dom";
import { AppContext } from '../contexts/contexts';
import "./shops.css"

export async function loader({ params }) {
    const shop = await getBaskShopById(params.shopId);
    return { shop };
}

export default function ShopsUpdate() {
    const navigate = useNavigate();

    const { shop } = useLoaderData();
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
                onClick={updateBaskShopClick}>
                Update
            </button>
        </section>
    );

    async function updateBaskShopClick() {
        shop.title = title
        shop.rating = rating
        shop.user = appContext.user
        await updateBaskShop(shop)
        navigate('/shops')
    }
}
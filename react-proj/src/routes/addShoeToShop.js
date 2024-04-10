import React, { useState } from 'react';
import { getBaskShopById, addShoeToShop } from "../api/shopService"
import { getBaskShoe } from "../api/shoeService"
import { useLoaderData, useNavigate } from "react-router-dom";
import "./shops.css"

export async function loader({ params }) {
    const shop = await getBaskShopById(params.shopId);
    return { shop };
}

export default function AddShoeToShop() {
    const navigate = useNavigate();

    const { shop } = useLoaderData();
    const [shoes, setShoes] = useState([]);
    const [shoeId, setShoeId] = useState();

    loadShoes()

    return (
        <section className="form-container-shoes">
            <h2>Shoes</h2>
            
            <table className="table table-striped table-hover">   
                <thead>
                    <tr>
                        <th>
                            Id
                        </th>
                        <th>
                            Title
                        </th>
                        <th>
                            Price
                        </th>
                        <th>
                            Description
                        </th>
                        <th>
                            Manufacturer
                        </th>
                        <th>
                            Brand
                        </th>
                        <th>
                            Size
                        </th>
                    </tr>
                </thead>
                <tbody>
                    {shoes.map(shoe =>
                        <tr key={shoe.id}>
                            <td>
                                {shoe.id}
                            </td>
                            <td>
                                {shoe.title}
                            </td>
                            <td>
                                {shoe.price}
                            </td>
                            <td>
                                {shoe.description}
                            </td>
                            <td>
                                {shoe.manufacturer}
                            </td>
                            <td>
                                {shoe.brand}
                            </td>
                            <td>
                                {shoe.size}
                            </td>
                        </tr>
                    )}
                </tbody>
            </table> 

            <section className="form-container">
                <input
                    placeholder="ShoeId"
                    className="form-control"
                    type="number"
                    onChange={(e) => setShoeId(e.target.value)}
                />
                <button
                    className="btn btn-info"
                    onClick={addShoeToShopClick}>
                    Add
                </button>
            </section>
        </section>
    );

    async function loadShoes() {
        const shoes = await getBaskShoe()
        setShoes(shoes)
    }

    async function addShoeToShopClick() {
        await addShoeToShop(shop.id, shoeId)
        navigate('/shops')
    }
}
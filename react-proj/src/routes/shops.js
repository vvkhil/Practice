import React, { useState, useEffect } from 'react';
import { getBaskShops, removeBaskShopById, getBaskShopById } from "../api/shopService"
import { Link } from "react-router-dom";
import "./shops.css"

export async function loader({ params }) {
    const shop = await getBaskShopById(params.shopId);
    return { shop };
}

export default function Shops() {
    const [shops, setShops] = useState([]);
    const [reload, setReload] = useState(false);

    useEffect(() => {
        loadShops()
    }, [reload]);

    return (
        <section>

            <h2>Shops</h2>
            
            <table className="table table-striped table-hover">   
                <thead>
                    <tr>
                        <th>
                            Title
                        </th>
                        <th>
                            Rating
                        </th>
                        <th>
                            <Link to="add/" className="btn btn-success">Add</Link>
                        </th>
                    </tr>
                </thead>
                <tbody>
                    {shops.map(shop =>
                        <tr key={shop.id}>
                            <td>
                                {shop.title}
                            </td>
                            <td>
                                {shop.rating}
                            </td>
                            <td>
                                <Link to={`update/${shop.id}`} className="btn btn-info">Update</Link>
                                <button 
                                    onClick={() => removeBaskShop(shop.id)} 
                                    value={shop.id} 
                                    className="btn btn-danger">
                                        Delete
                                </button>
                                <th>
                                    <Link to={`add/${shop.id}`} className="btn btn-primary">Add shoes</Link>
                                </th>
                                <th>
                                    <Link to={`delete/${shop.id}`} className="btn btn-primary">Delete shoes</Link>
                                </th>
                                <th>
                                    <Link to={`get/${shop.id}`} className="btn btn-primary">Show shoes</Link>
                                </th>
                            </td>
                        </tr>
                    )}
                </tbody>
            </table>

        </section>
    );

    async function loadShops() {
        const shops = await getBaskShops()
        setShops(shops)
    }

    async function removeBaskShop(id) {
        await removeBaskShopById(id)
        setReload(!reload)
    }
}

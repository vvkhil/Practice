import React, { useState, useEffect } from 'react';
import { getBaskShoe, removeBaskShoeById, getBaskShoeById } from "../api/shoeService"
import { Link } from "react-router-dom";
import "./shoes.css"

export async function loader({ params }) {
    const shoe = await getBaskShoeById(params.shoeId);
    return { shoe };
}

export default function Shoes() {
    const [shoes, setShoes] = useState([]);
    const [reload, setReload] = useState(false);

    useEffect(() => {
        loadShoes()
    }, [reload]);

    return (
        <section >
            <div>
                <h2>Shoes</h2>
                
                <table className="table table-striped table-hover">   
                    <thead>
                        <tr>
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
                            <th>
                                <Link to="add/" className="btn btn-success">Add</Link>
                            </th>
                        </tr>
                    </thead>
                    <tbody>
                        {shoes.map(shoe =>
                            <tr key={shoe.id}>
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
                                <td>
                                    <Link to={`update/${shoe.id}`} className="btn btn-info">Update</Link>
                                    
                                    <button 
                                        onClick={() => removeBaskShoe(shoe.id)} 
                                        value={shoe.id} 
                                        className="btn btn-danger">
                                            Delete
                                    </button>
                                </td>
                            </tr>
                        )}
                    </tbody>
                </table>
            </div>
        </section>
    );

    async function loadShoes() {
        const shoes = await getBaskShoe()
        console.log(shoes)
        setShoes(shoes)
    }

    async function removeBaskShoe(id) {
        await removeBaskShoeById(id)
        setReload(!reload)
    }
}



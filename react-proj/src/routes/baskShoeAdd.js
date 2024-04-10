import React, { useState } from 'react';
import { addBaskShoe } from "../api/shoeService"
import { useNavigate } from "react-router-dom";
import "./shoes.css"

export default function BaskShoeAdd() {
    const navigate = useNavigate();

    const [title, setTitle] = useState('');
    const [price, setPrice] = useState('');
    const [description, setDescription] = useState('');
    const [manufacturer, setManufacturer] = useState('');
    const [brand, setBrand] = useState('');
    const [size, setSize] = useState('');

    return (
        <section className="form-container">
            <input
                placeholder="Title"
                className="form-control"
                type="text"
                onChange={(e) => setTitle(e.target.value)}
            />
            <input
                placeholder="Price"
                className="form-control"
                type="number"
                onChange={(e) => setPrice(e.target.value)}
            />
            <input
                placeholder="Description"
                className="form-control"
                type="text"
                onChange={(e) => setDescription(e.target.value)}
            />
            <input
                placeholder="Manufacturer"
                className="form-control"
                type="text"
                onChange={(e) => setManufacturer(e.target.value)}
            />
            <input
                placeholder="Brand"
                className="form-control"
                type="text"
                onChange={(e) => setBrand(e.target.value)}
            />
            <input
                placeholder="Size"
                className="form-control"
                type="number"
                onChange={(e) => setSize(e.target.value)}
            />
            <button
                className="btn btn-info"
                onClick={addBaskShoeClick}>
                Add
            </button>
        </section>
    );

    async function addBaskShoeClick() {
        let shoe = {}
        shoe.id = null
        shoe.title = title
        shoe.price = price
        shoe.description = description
        shoe.manufacturer = manufacturer
        shoe.brand = brand
        shoe.size = size
        console.log(shoe)
        await addBaskShoe(shoe)
        navigate('/shoes')
    }
}
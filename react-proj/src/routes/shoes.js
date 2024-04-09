import React, { useState, useEffect } from 'react';
import { getBaskShoe, removeBaskShoeById, getBaskShoeById, addBaskShoe, updateBaskShoe } from "../api/shoeService"
import { Link, useLoaderData, useNavigate } from "react-router-dom";

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
                                <Link to="add/" className="btn btn-success">Добавить</Link>
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
                                    <Link to={`update/${shoe.id}`} className="btn btn-info">Изменить</Link>
                                    |
                                    <button 
                                        onClick={() => removeBaskShoe(shoe.id)} 
                                        value={shoe.id} 
                                        className="btn btn-danger">
                                            Удалить
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

export function BaskShoeAdd() {
    const navigate = useNavigate();

    const [id, setId] = useState('');
    const [title, setTitle] = useState('');
    const [price, setPrice] = useState('');
    const [description, setDescription] = useState('');
    const [manufacturer, setManufacturer] = useState('');
    const [brand, setBrand] = useState('');
    const [size, setSize] = useState('');

    return (
        <section class="form-container">
            <div class="form">
                <input
                    placeholder="Id"
                    class="form-control"
                    type="number"
                    onChange={(e) => setId(e.target.value)}
                />
                <input
                    placeholder="Title"
                    class="form-control"
                    type="text"
                    onChange={(e) => setTitle(e.target.value)}
                />
                <input
                    placeholder="Price"
                    class="form-control"
                    type="number"
                    onChange={(e) => setPrice(e.target.value)}
                />
                <input
                    placeholder="Description"
                    class="form-control"
                    type="text"
                    onChange={(e) => setDescription(e.target.value)}
                />
                <input
                    placeholder="Manufacturer"
                    class="form-control"
                    type="text"
                    onChange={(e) => setManufacturer(e.target.value)}
                />
                <input
                    placeholder="Brand"
                    class="form-control"
                    type="text"
                    onChange={(e) => setBrand(e.target.value)}
                />
                <input
                    placeholder="Size"
                    class="form-control"
                    type="number"
                    onChange={(e) => setSize(e.target.value)}
                />
                <button
                    onClick={addBaskShoeClick}>
                    Добавить
                </button>
            </div>
        </section>
    );

    async function addBaskShoeClick() {
        let shoe = {}
        shoe.id = id
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

export function ShoesUpdate() {
    const navigate = useNavigate();
    
    const { shoe } = useLoaderData();
    const [title, setTitle] = useState('');
    const [price, setPrice] = useState('');
    const [description, setDescription] = useState('');
    const [manufacturer, setManufacturer] = useState('');
    const [brand, setBrand] = useState('');
    const [size, setSize] = useState('');

    return (
        <section class="form-container">
            <div class="form">
                <input
                    placeholder="Title"
                    class="form-control"
                    type="text"
                    onChange={(e) => setTitle(e.target.value)}
                />
                <input
                    placeholder="Price"
                    class="form-control"
                    type="number"
                    onChange={(e) => setPrice(e.target.value)}
                />
                <input
                    placeholder="Description"
                    class="form-control"
                    type="text"
                    onChange={(e) => setDescription(e.target.value)}
                />
                <input
                    placeholder="Manufacturer"
                    class="form-control"
                    type="text"
                    onChange={(e) => setManufacturer(e.target.value)}
                />
                <input
                    placeholder="Brand"
                    class="form-control"
                    type="text"
                    onChange={(e) => setBrand(e.target.value)}
                />
                <input
                    placeholder="Size"
                    class="form-control"
                    type="number"
                    onChange={(e) => setSize(e.target.value)}
                />
                <button
                    onClick={updateBaskShoeClick}>
                    Изменить
                </button>
            </div>
        </section>
    );

    async function updateBaskShoeClick() {
        shoe.title = title
        shoe.price = price
        shoe.description = description
        shoe.manufacturer = manufacturer
        shoe.brand = brand
        shoe.size = size
        await updateBaskShoe(shoe)
        navigate('/shoes')
    }
}

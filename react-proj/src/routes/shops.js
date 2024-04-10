import React, { useState, useEffect, useContext } from 'react';
import { getBaskShops, removeBaskShopById, getBaskShopById, addBaskShop, updateBaskShop, addShoeToShop, removeShoeFromShop } from "../api/shopService"
import { getBaskShoe, getShoesByShopId } from "../api/shoeService"
import { Link, useLoaderData, useNavigate } from "react-router-dom";
import { AppContext } from '../contexts/contexts';
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
        <section >
            <div>
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
            </div>
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

export function BaskShopAdd() {
    const navigate = useNavigate();

    const [id, setId] = useState('');
    const [title, setTitle] = useState('');
    const [rating, setRating] = useState('');

    const appContext = useContext(AppContext);

    return (
        <section className="form-container">
            <input
                placeholder="Id"
                className="form-control"
                type="number"
                onChange={(e) => setId(e.target.value)}
            />
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
        shop.id = id
        shop.title = title
        shop.rating = rating
        shop.user = appContext.user
        await addBaskShop(shop)
        navigate('/shops')
    }
}

export function ShopsUpdate() {
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

export function AddShoeToShop() {
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

export function RemoveShoeFromShop() {
    const navigate = useNavigate();

    const { shop } = useLoaderData();
    const [shoes, setShoes] = useState([]);
    const [shoeId, setShoeId] = useState();
    
    loadShoes()

    return (
        <section class="form-container-shoes">
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
                    className="btn btn-danger"
                    onClick={removeShoeFromShopClick}>
                    Delete
                </button>
            </section>        
    
        </section>
    );

    async function loadShoes() {
        const shoes = await getBaskShoe()
        setShoes(shoes)
    }

    async function removeShoeFromShopClick() {
        await removeShoeFromShop(shop.id, shoeId)
        navigate('/shops')
    }
}

export function GetShoesByShop() {

    const { shop } = useLoaderData();
    const [shoes, setShoes] = useState([]);
  
    loadShoes()

    return (
        <section class="form-container-shoes">

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

        </section>
    );

    async function loadShoes() {
        const shoes = await getShoesByShopId(shop.id)
        setShoes(shoes)
    }

}
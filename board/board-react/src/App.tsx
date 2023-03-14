import React, { useEffect, useState } from "react";
import axios from "axios";
import logo from './logo.svg';
import './App.css';
import SignUp from "./view/Authentication/SignUp";
import Athentication from "./view/Authentication";
import MainLayout from "./view/layouts/MainLayout";

export default function App() {
  return (
    // <Athentication />
    <MainLayout />
  );
}
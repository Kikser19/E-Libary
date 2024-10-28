import { initializeApp } from "firebase/app";
import { getAuth } from "firebase/auth"

const firebaseConfig = {
    apiKey: "AIzaSyACZWJQuT42CdNesy5rqyTrbrCfc8T_d5w",
    authDomain: "e-libary-81ae9.firebaseapp.com",
    projectId: "e-libary-81ae9",
    storageBucket: "e-libary-81ae9.appspot.com",
    messagingSenderId: "825713772452",
    appId: "1:825713772452:web:261871657201cc6276e331",
    measurementId: "G-DZEK447N8L"
};

// Initialize Firebase
const app = initializeApp(firebaseConfig);

export const auth=getAuth();
export default app;
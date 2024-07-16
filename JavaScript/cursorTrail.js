function neonCursor(config) {
    const {
        canvas,
        lineWidth,
        color,
        fadeSpeed,
        glowColor,
        glowBlur
    } = config;

    const ctx = canvas.getContext('2d');
    canvas.width = window.innerWidth;
    canvas.height = window.innerHeight;

    let trail = [];

    function onMouseMove(e) {
        trail.push({ x: e.clientX, y: e.clientY, opacity: 1 });
    }

    function drawTrail() {
        ctx.clearRect(0, 0, canvas.width, canvas.height);

        ctx.beginPath();
        for (let i = 0; i < trail.length; i++) {
            const point = trail[i];
            const opacity = Math.max(0, point.opacity); // Ensure opacity is not negative

            if (i === 0) {
                ctx.moveTo(point.x, point.y);
            } else {
                ctx.lineTo(point.x, point.y);
            }
        }

        // Apply glow effect
        ctx.shadowColor = glowColor;
        ctx.shadowBlur = glowBlur;
        ctx.strokeStyle = color;
        ctx.lineWidth = lineWidth;
        ctx.lineCap = 'round';
        ctx.stroke();

        // Fade out the trail
        trail.forEach(point => {
            point.opacity -= fadeSpeed;
        });

        // Remove points with opacity <= 0
        trail = trail.filter(point => point.opacity > 0);
    }

    function animate() {
        drawTrail();
        requestAnimationFrame(animate);
    }

    function resizeCanvas() {
        canvas.width = window.innerWidth;
        canvas.height = window.innerHeight;
    }

    window.addEventListener('mousemove', onMouseMove);
    window.addEventListener('resize', resizeCanvas);

    animate();
}

neonCursor({
    canvas: document.getElementById('neonCanvas'),
    lineWidth: 4,
    color: '#0f0',
    fadeSpeed: 0.05, // Adjust the fade speed as needed
    glowColor: 'rgba(0, 255, 0, 0.2)', // Adjust glow color and opacity
    glowBlur: 10 // Adjust glow blur radius
});

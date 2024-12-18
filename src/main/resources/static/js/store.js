document.addEventListener('DOMContentLoaded', function() {
    document.getElementById('dark-mode-toggle').addEventListener('click', function() {
        document.body.classList.toggle('dark-mode');
    });

    document.getElementById('language-toggle').addEventListener('click', function() {
        // Language toggle functionality
    });

    document.getElementById('user-button').addEventListener('click', function() {
        // User button functionality
    });

    const carousel = {
        currentSlide: 0,
        items: document.querySelectorAll('.carousel-item'),
        total: document.querySelectorAll('.carousel-item').length,
        
        next() {
            this.showSlide((this.currentSlide + 1) % this.total);
        },
        
        prev() {
            this.showSlide((this.currentSlide - 1 + this.total) % this.total);
        },
        
        showSlide(n) {
            this.items[this.currentSlide].classList.remove('active');
            this.currentSlide = n;
            this.items[this.currentSlide].classList.add('active');
        }
    };

    setInterval(() => carousel.next(), 5000);

    document.querySelector('.carousel-control.prev').addEventListener('click', () => carousel.prev());
    document.querySelector('.carousel-control.next').addEventListener('click', () => carousel.next());

    const reservationForm = document.getElementById('reservationForm');
    if (reservationForm) {
        reservationForm.addEventListener('submit', function(e) {
            e.preventDefault();
            const formData = new FormData(this);
            const reservationData = {
                veiculo: { placa: formData.get('placa') },
                dataInicio: formData.get('dataInicio'),
                dataFim: formData.get('dataFim')
            };

            fetch('/api/reserva/create', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(reservationData)
            })
            .then(response => response.text())
            .then(message => {
                alert(message);
                if (message.includes('sucesso')) {
                    location.reload();
                }
            })
            .catch(error => {
                console.error('Error:', error);
                alert('Erro ao realizar reserva');
            });
        });
    }
});
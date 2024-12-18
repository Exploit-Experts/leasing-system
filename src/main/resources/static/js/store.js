document.addEventListener('DOMContentLoaded', function() {

    if (localStorage.getItem('dark-mode') === 'enabled') {
        document.body.classList.add('dark-mode');
    }

    document.getElementById('dark-mode-toggle').addEventListener('click', function() {
        document.body.classList.toggle('dark-mode');
        if (document.body.classList.contains('dark-mode')) {
            localStorage.setItem('dark-mode', 'enabled');
        } else {
            localStorage.setItem('dark-mode', 'disabled');
        }
    });

    document.getElementById('language-toggle').addEventListener('click', function() {
    });

    document.getElementById('user-button').addEventListener('click', function() {
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
            const dataInicio = new Date(formData.get('dataInicio'));
            const dataFim = new Date(formData.get('dataFim'));

            if (dataInicio > dataFim) {
                alert('A data de início não pode ser posterior à data de fim.');
                return;
            }

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

    document.querySelectorAll('.return-btn').forEach(button => {
        button.addEventListener('click', function() {
            const reservaId = this.getAttribute('data-reserva-id');
            if (confirm('Tem certeza que deseja devolver este veículo?')) {
                fetch(`/api/reserva/${reservaId}/return`, {
                    method: 'POST'
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
                    alert('Erro ao devolver o veículo');
                });
            }
        });
    });
});
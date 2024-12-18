document.addEventListener('DOMContentLoaded', function () {

  if (localStorage.getItem('dark-mode') === 'enabled') {
    document.body.classList.add('dark-mode');
  }

  document.querySelectorAll('.edit-btn').forEach(button => {
    button.addEventListener('click', function () {
      const id = this.dataset.id;
      const type = this.closest('.user-list') ? 'user' : 'car';
      handleEdit(id, type);
    });
  });

  document.querySelectorAll('.delete-btn').forEach(button => {
    button.addEventListener('click', function () {
      const id = this.dataset.id;
      const type = this.closest('.user-list') ? 'user' : 'car';
      handleDelete(id, type);
    });
  });

  const addCarForm = document.getElementById('addCarForm');
  if (addCarForm) {
    addCarForm.addEventListener('submit', function (e) {
      e.preventDefault();
      const formData = new FormData(this);
      const carData = {
        placa: formData.get('placa'),
        marca: formData.get('marca'),
        modelo: formData.get('modelo'),
        ano: parseInt(formData.get('ano')),
        cor: formData.get('cor'),
        disponivel: true
      };

      fetch('/api/car/create', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(carData)
      })
        .then(response => {
          if (response.ok) {
            location.reload();
          } else {
            response.text().then(text => {
              alert('Erro ao adicionar veículo: ' + text);
            });
          }
        })
        .catch(error => {
          console.error('Error:', error);
          alert('Erro ao adicionar veículo');
        });
    });
  }

  document.getElementById('dark-mode-toggle').addEventListener('click', function() {
    document.body.classList.toggle('dark-mode');
    if (document.body.classList.contains('dark-mode')) {
      localStorage.setItem('dark-mode', 'enabled');
  } else {
      localStorage.setItem('dark-mode', 'disabled');
  }
  });

});

function handleEdit(id, type) {
  if (type === 'car') {
    const row = document.querySelector(`.info-row[data-car-id="${id}"]`);
    const editActions = row.querySelector('.edit-actions');
    const values = row.querySelectorAll('.info-value:not([data-field="disponivel"]):not([data-field="usuario"])');
    const originalValues = {};

    values.forEach(value => {
      const field = value.getAttribute('data-field');
      originalValues[field] = value.textContent;
      value.contentEditable = true;
      value.classList.add('editing');
    });

    const statusValue = row.querySelector('[data-field="disponivel"]').textContent;
    const isDisponivel = statusValue === 'Disponível';

    editActions.classList.add('active');

    editActions.querySelector('.save-btn').onclick = () => {
      const updatedData = {
        id: id,
        modelo: row.querySelector('[data-field="modelo"]').textContent,
        marca: row.querySelector('[data-field="marca"]').textContent,
        ano: parseInt(row.querySelector('[data-field="ano"]').textContent),
        placa: row.querySelector('[data-field="placa"]').textContent,
        cor: row.querySelector('[data-field="cor"]').textContent,
        disponivel: isDisponivel
      };

      fetch(`/api/car/${id}`, {
        method: 'PUT',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(updatedData)
      })
      .then(response => {
        if (response.ok) {
          exitEditMode();
          location.reload();
        } else {
          return response.text().then(text => {
            throw new Error(text || 'Erro ao atualizar veículo');
          });
        }
      })
      .catch(error => {
        console.error('Error:', error);
        alert(error.message);
      });
    };

    editActions.querySelector('.cancel-btn').onclick = () => {
      values.forEach(value => {
        value.textContent = originalValues[value.dataset.field];
        exitEditMode();
      });
    };

    function exitEditMode() {
      values.forEach(value => {
        value.contentEditable = false;
        value.classList.remove('editing');
      });
      editActions.classList.remove('active');
    }
  } else {
    window.location.href = `/${type}/edit/${id}`;
  }
}

function handleDelete(id, type) {
  if (confirm(`Are you sure you want to delete this ${type}?`)) {
    fetch(`/api/${type}/${id}`, {
      method: 'DELETE',
      headers: {
        'Content-Type': 'application/json',
      }
    })
      .then(response => {
        if (response.ok) {
          location.reload();
        } else {
          return response.text().then(text => {
            try {
              const data = JSON.parse(text);
              if (data.error && data.error.includes('active reservations')) {
                if (type === 'user') {
                  document.getElementById('user-reservation-error').style.display = 'block';
                } else {
                  document.getElementById('car-reservation-error').style.display = 'block';
                }
              } else {
                alert('Error deleting item: ' + (data.message || data.error || 'Unknown error'));
              }
              throw new Error(data.message || data.error || 'Unknown error');
            } catch (e) {
              alert('Error deleting item: ' + text);
              throw new Error(text);
            }
          });
        }
      })
      .catch(error => {
        console.error('Error:', error);
        if (error.message === 'Failed to fetch') {
          alert('Network error: Failed to connect to the server.');
        }
      });
  }
}

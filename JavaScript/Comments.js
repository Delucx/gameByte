document.addEventListener('DOMContentLoaded', () => {
    const commentForm = document.getElementById('commentForm');
    const commentTextarea = document.getElementById('comment');
    const recommendYes = document.getElementById('yes');
    const recommendNo = document.getElementById('no');

    commentForm.addEventListener('submit', e => {
        e.preventDefault();
        validateComment();
    });

    const setError = (element, message) => {
     
        const existingError = element.parentElement.querySelector('.error');
        if (existingError) {
            existingError.remove();
        }

        
        const errorDisplay = document.createElement('p');
        errorDisplay.className = 'error';
        errorDisplay.innerText = message;
        element.parentElement.appendChild(errorDisplay);
    };

    const validateComment = () => {
        const commentValue = commentTextarea.value.trim();
        const recommendValue = recommendYes.checked || recommendNo.checked;

        
        clearErrors();

        let isValid = true;

        if (commentValue === '' || commentValue === 'Write a Review...') {
            setError(commentTextarea, 'Please write your review before submitting.');
            isValid = false;
        }

        if (!recommendValue) {
            setError(document.querySelector('.recommendCont'), 'Please indicate if you recommend the game.');
            isValid = false;
        }

        if (isValid) {
           
            commentForm.submit();
        }
    };

    const clearErrors = () => {
        const errors = document.querySelectorAll('.error');
        errors.forEach(error => error.remove());
    };

    commentTextarea.addEventListener('input', () => {
        clearErrors();
    });

    [recommendYes, recommendNo].forEach(radio => {
        radio.addEventListener('change', () => {
            clearErrors();
        });
    });
});
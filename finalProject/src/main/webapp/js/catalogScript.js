function booksCatalog(selector) {

    let catalog = $(selector);
    let button = catalog.find('.books_catalog_button');
    let links = catalog.find('.books_catalog_link');
    let overlay = catalog.find('.books_catalog_overlay');

    button.on('click', (e) => {
        e.preventDefault();
        toggleCatalog();
    });

    links.on('click', () => toggleCatalog());
    overlay.on('click', () => toggleCatalog());

    function toggleCatalog() {
        catalog.toggleClass('books_catalog_active');

        if (catalog.hasClass('books_catalog_active')) {
            $('body').css('overflow', 'hidden');
        } else {
            $('body').css('overflow', 'visible');
        }
    }
}

booksCatalog('.books_catalog');
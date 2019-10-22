$(function() {

    const ul = $(".slider ul");
    const slide_count = ul.children().length;
    const slide_width_pc = 100.0 / slide_count;
    let slide_index = 0;

    const first_slide = ul.find("li:first-child");
    const last_slide = ul.find("li:last-child");

    // Clone the last slide and add as first li element
    last_slide.clone().prependTo(ul);

    // Clone the first slide and add as last li element
    first_slide.clone().appendTo(ul);

    ul.find("li").each(function(indx) {
        const left_percent = (slide_width_pc * indx) + "%";
        $(this).css({"left":left_percent});
        $(this).css({width:(100 / slide_count) + "%"});
    });

    ul.css("margin-left", "-100%");

    // Listen for click of prev button
    $(".slider .prev").click(function() {
        console.log("prev button clicked");
        slide(slide_index - 1);
    });

    // Listen for click of next button
    $(".slider .next").click(function() {
        console.log("next button clicked");
        slide(slide_index + 1);
    });

    function slide(new_slide_index) {

        const margin_left_pc = (new_slide_index * (-100) - 100) + "%";

        ul.animate({"margin-left": margin_left_pc}, 400, function() {

            // If new slide is before first slide...
            if(new_slide_index < 0) {
                ul.css("margin-left", ((slide_count) * (-100)) + "%");
                new_slide_index = slide_count - 1;
            }
            // If new slide is after last slide...
            else if(new_slide_index >= slide_count) {
                ul.css("margin-left", "-100%");
                new_slide_index = 0;
            }

            slide_index = new_slide_index

        });

    }

    let mousein = function () {
        $(this).css("opacity",0).addClass("over")
            .animate({height:"500px", width: "800px", opacity:"1"});
    }

    let mouseout = function () {
        $(this).removeClass("over")
            .animate({height: "100%", width:"100%"})
    }

    $(".rel").children().hover(mousein, mouseout)

});
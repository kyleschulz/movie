var app = new Vue({
    el: '#app',
    data: {
        message: 'Hello Vue!',
        seen: true,
        show: true,
        todos: [
            { text: 'Learn JavaScript' },
            { text: 'Learn Vue' },
            { text: 'Build something awesome' }
        ],
        message2: 'Hello there!',
        message3: 'Hello there Vue.js!',
        counter: 0
    },
    methods: {
        reverseMessage: function () {
            this.message3 = this.message3.split('').reverse().join('')
        },
        greet: function (event) {
            // 'this' points to the Vue instance
            alert('Hello ' + this.name + '!')
            // 'event' is the native DOM event
            if (event) {
                alert(event.target.tagName)
            }
        },
        say: function (message) {
            alert(message)
        }
    }
})
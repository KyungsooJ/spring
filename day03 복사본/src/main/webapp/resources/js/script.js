'use strict';

function resizeHandler() {
	const textarea = document.querySelector('textarea[name="iframe"]')

	const src = textarea.value
	const idx = src.indexOf('src=')
	const text2 = src.slice(idx)

	textarea.value = '<iframe width="720" height="405" ' + text2
}
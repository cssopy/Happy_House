const regionCode = document.getElementById('regionCode');

document.getElementById('gugun').addEventListener('change', () => {
	if (gugun.value === '강남구') {
		regionCode.value = '11680';
	} else if (gugun.value === '송파구') {
		regionCode.value = '11710';
	} else {
		regionCode.removeAttribute('value');
	}
});
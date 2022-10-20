

    function strToBytes(str) {
        var result = new Array();
        var k = 0;
        for (var i = 0; i < str.length; i++) {
            var j = encodeURI(str[i]);
            if (j.length == 1) {
                result[k++] = j.charCodeAt(0);
            } else {
                var bytes = j.split("%");
                for (var l = 1; l < bytes.length; l++) {
                    result[k++] = parseInt(bytes[l], 16);
                }
            }
        }
        return result;
    }
    function bytesToStr(utf8) {
        var result = new Array();
        var k = 0;
        for (var i = 0; i < utf8.length; i++) {
            var c = utf8[i];
            if (c < 0x80) {
                result[k++] = String.fromCharCode(c);
            } else if (c < 0xE0) {
                result[k++] = String.fromCharCode(((c & 0x3F) << 6) | (utf8[i + 1] & 0x7F));
                i++;
            } else if (c < 0xF0) {
                result[k++] = String.fromCharCode(((c & 0x1F) << 12) | ((utf8[i + 1] & 0x7F) << 6) | (utf8[i + 2] & 0x7F));
                i += 2;
            } else {
                result[k++] = String.fromCharCode(((c & 0x0F) << 18) | ((utf8[i + 1] & 0x7F) << 12) | ((utf8[i + 2] & 0x7F) << 6) | (utf8[i + 3] & 0x7F));
                i += 3;
            }
        }
        return result.join("");
    }
    function bytesToHex(bytes) {
        var result = "";
        for (var i = 0; i < bytes.length; i++) {
        let hex = Number(bytes[i] % 256)
            hex = (hex < 0 ? hex + 256 : hex).toString(16);
            if (hex.length < 2) {
                hex = "0" + hex;
            }
            result += hex;
        }
        return result.toString();
    }
    function hexToBytes(hex) {
        var hexlen = hex.length;
        var result = new Array();
        if (hexlen % 2 == 1) {
            hexlen++;
            hex = "0" + hex;
        }
        var j = 0;
        for (var i = 0; i < hexlen; i += 2) {
            result[j++] = parseInt(hex.substring(i, i + 2), 16);
        }
        return result;
    }
    function initKey(key) {
        var bkey = new Array();
        bkey = strToBytes(key);
        var s = new Array();
        for (var i = 0; i < 256; i++) {
            s[i] = i;
        }
        var index1 = 0;
        var index2 = 0;
        for (var i = 0; i < 256; i++) {
            index2 = ((bkey[index1] % 256) + (s[i] % 256) + index2) % 256;
            var temp = s[i];
            s[i] = s[index2];
            s[index2] = temp;
            index1 = (index1 + 1) % bkey.length;
        }
        return s;
    }
    function RC4Base(data, key) {
        var x = 0;
        var y = 0;
        var key = initKey(key);
        var xorIndex;
        var result = new Array();
        for (var i = 0; i < data.length; i++) {
            x = (x + 1) % 256;
            y = (y + (key[x] % 256)) % 256;
            var temp = key[x];
            key[x] = key[y];
            key[y] = temp;
            xorIndex = ((key[x] % 256) + (key[y] % 256)) % 256;
            result[i] = data[i] ^ key[xorIndex];
        }
        return result;
    }
    function encryptRC4(data, key) {
        return bytesToHex(RC4Base(strToBytes(data), key));
    }
    function decryptRC4(data, key) {
        return bytesToStr(RC4Base(hexToBytes(data), key));
    }
    function countEncrypt(count) {
        let count2 = count+"muyu"
        return encryptRC4(count2,"muyu")
    }

export {
    countEncrypt,
    decryptRC4,
    encryptRC4
} 








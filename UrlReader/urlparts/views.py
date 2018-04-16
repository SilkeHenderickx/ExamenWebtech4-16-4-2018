# -*- coding: utf-8 -*-
from __future__ import unicode_literals
from urlparse import urlparse

from django.shortcuts import render

# Create your views here.

def read_url(request, param):


    url = request.get_full_path()
    parse_object = urlparse(url)
    string = parse_object.path[9:]
    newstring = string.replace("/", "***")

    return render(request, 'index.html', {'url': newstring })

def index(request):
    return render(request, 'index.html')
